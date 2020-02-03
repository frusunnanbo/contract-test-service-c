#!/bin/bash

FAT_GREEN="\[\e[1;32m\]"
GIT_YELLOW="\[\e[0;33m\]"
NORMAL="\[\e[m\]"
PS1="${FAT_GREEN}Service C${NORMAL}$GIT_YELLOW"'$(__git_ps1 " (%s)")'" $FAT_GREEN$ $NORMAL"

