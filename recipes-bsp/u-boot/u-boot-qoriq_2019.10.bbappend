FILESEXTRAPATHS_prepend := "${THISDIR}/patches:${THISDIR}/files:"
SRCBRANCH = "trustbox-2004-atf"
SRC_URI = "gitsm://github.com/Scalys/u-boot-qoriq.git;protocol=git;branch=${SRCBRANCH} \
    \
    file://0001-scripts-dtc-Remove-YYLTYPE-yylloc-declaration.patch \
"
SRCREV = "d91b8b6a854786802208530ac7aa26e0b7e7b822"
