DESCRIPTION = "Composite QSPI firmware"

LICENSE = "BSD"

inherit deploy

DEPENDS += "atf ppfe-firmware"
do_compile[depends] += "atf:do_deploy ppfe-firmware:do_deploy"

COMPATIBLE_MACHINE = "(qoriq)"

do_configure[noexec] = "1"

do_compile() {
	dd if=${DEPLOY_DIR_IMAGE}/atf/bl2_qspi.pbl of=${S}/firmware.bin bs=1
	dd if=${DEPLOY_DIR_IMAGE}/atf/fip_uboot.bin of=${S}/firmware.bin bs=1 seek=1048576
	dd if=${DEPLOY_DIR_IMAGE}/engine-pfe-bin/pfe_fw_sbl.itb of=${S}/firmware.bin bs=1 seek=10485760
}

do_install() {
    install -d ${D}/boot
    cp -r ${S}/firmware.bin ${D}/boot
    chown -R root:root ${D}
}

do_deploy() {
	install -d ${DEPLOYDIR}/composite-firmware
	cp -r ${S}/firmware.bin ${DEPLOYDIR}/composite-firmware/
}

addtask deploy after do_install
FILES_${PN} += "/boot"
BBCLASSEXTEND = "native nativesdk"

