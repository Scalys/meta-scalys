LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS += "u-boot-mkimage-native"

SRC_URI += "\
  file://${SCRIPT_SOURCE} \
  file://COPYING \
"

inherit kernel-arch

SCRIPT_SOURCE ?= "flash-fw.cmd"
SCRIPT_DEST ?= "flash-fw.scr"
SCRIPT_DESC ?= "QSPI firmware flash"

do_compile() {
    uboot-mkimage -A ${UBOOT_ARCH} -O linux -T script -C none -a 0 -e 0 -n "${SCRIPT_DESC}" -d "${WORKDIR}/${SCRIPT_SOURCE}" ${SCRIPT_DEST}
}

do_install() {
    mkdir -p ${D}/boot
    install -m 0644 ${SCRIPT_DEST} ${D}/boot/${SCRIPT_DEST}
}


FILES:${PN} = "/boot/${SCRIPT_DEST}"