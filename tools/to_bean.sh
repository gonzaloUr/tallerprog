#!/bin/sh

INDENT='    '

dir="$(dirname "$1")/"
class=${1##$dir}
class=${class%'.java'}

fields="$(sed -n '/private .*;/p' "$1" |\
    sed 's/private//g ; s/public//g ; s/protected//g ; s/static//g ; s/final//g ; s/synchronized//g' |\
    sed "/$INDENT$INDENT/d" |\
    sed 's/[[:space:]]*=.*;$/;/g' |\
    sed 's/^[[:space:]]*//g')"

bean="$2"

cat "$1" | sed -n '/package/,/class/p' | sed '$d'

printf 'public class %s {\n\n' "$bean"

tmp="$IFS"
IFS='
'

for field in $fields
do
    printf '%sprivate %s\n\n' "$INDENT" "$field"
done

IFS="$tmp"

printf '%spublic %s() {}\n\n' "$INDENT" "$bean"

tmp="$IFS"
IFS='
'

for field in $fields
do
    tipo="$(echo "$field" | sed 's/ .*;$//g;')"
    name="$(echo "$field" | sed 's/^.* //g ; s/;//g')"

    first_letter="$(echo "$name" | cut -c1)"
    first_letter="$(echo "$first_letter" | tr '[:lower:]' '[:upper:]')"
    rest="$(echo "$name" | cut -c2-)"
    upper_name="${first_letter}${rest}"

    printf '%spublic %s get%s() {\n' "$INDENT" "$tipo" "$upper_name"
    printf '%s%sreturn this.%s;\n' "$INDENT" "$INDENT" "$name"
    printf '%s}\n\n' "$INDENT"

    printf '%spublic void set%s(%s %s) {\n' "$INDENT" "$upper_name" "$tipo" "$name"
    printf '%s%sthis.%s = %s;\n' "$INDENT" "$INDENT" "$name" "$name"
    printf '%s}\n\n' "$INDENT"
done
IFS="$tmp"

printf '%spublic void from(%s x) {\n' "$INDENT" "$class"

tmp="$IFS"
IFS='
'
for field in $fields
do
    tipo="$(echo "$field" | sed 's/ .*;$//g;')"
    name="$(echo "$field" | sed 's/^.* //g ; s/;//g')"

    first_letter="$(echo "$name" | cut -c1)"
    first_letter="$(echo "$first_letter" | tr '[:lower:]' '[:upper:]')"
    rest="$(echo "$name" | cut -c2-)"
    upper_name="${first_letter}${rest}"

    printf '%s%sset%s(x.get%s());\n' "$INDENT" "$INDENT" "$upper_name" "$upper_name"
done
IFS="$tmp"

printf '%s}\n' "$INDENT"
printf '}'
