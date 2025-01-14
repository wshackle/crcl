#!/bin/sh

set -x;

. ./setCrclUiEnvVars.sh

dir="${project.name}-javadoc"
if ! test -f "${dir}/index.html" ; then
    jarfile="${fullpath_javadoc_jar}"
    
    mkdir -p "${dir}";
    ( set -x; cd "${dir}"; jar -xf "../${jarfile}" ; )
fi

BASEURL="file://"`pwd`"/${dir}/index.html";
#UTILSURL="file://"`pwd`"/crcl4java-utils-javadoc/index.html";

if test "x${BROWSER}" != "x"  && which "${BROWSER}" >/dev/null 2>/dev/null ; then
    echo "Nothing to do BROWSER already set.";
elif which xdg-open >/dev/null 2>/dev/null; then
    export BROWSER=xdg-open;
elif which gnome-open >/dev/null 2>/dev/null; then
    export BROWSER=gnome-open;
elif which sensible-browser >/dev/null 2>/dev/null; then
    export BROWSER=sensible-browser;
elif which firefox >/dev/null 2>/dev/null; then
    export BROWSER=firefox;
elif which google-chrome >/dev/null 2>/dev/null; then
    export BROWSER=google-chrome;
elif which chromium-browser >/dev/null 2>/dev/null; then
    export BROWSER=chromium-browser;
elif which open >/dev/null 2>/dev/null; then
    export BROWSER=open;
else
    echo "No Web-Browser found."
fi

echo "BROWSER=${BROWSER}"

"${BROWSER}" "${BASEURL}" &
#"${BROWSER}" "${UTILSURL}" &
