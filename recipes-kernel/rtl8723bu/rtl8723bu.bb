FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SUMMARY = "Kernel module for Realtek RTL8723bu WiFi/Bluetooth USB module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

SRC_URI = "git://github.com/lwfinger/rtl8723bu.git;nobranch=1 \
    file://0001-Concurrent-AP-mode-removed-and-power-save-mode-disab.patch \
    file://COPYING \
"
SRCREV = "9ce1c38439f4f574bb7adaf33949835c25536a28"

inherit module

S = "${WORKDIR}/git"

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    export AR="${KERNEL_AR}"
    export CC="${KERNEL_CC}"
    export LD="${KERNEL_LD}"
    export O=${STAGING_KERNEL_BUILDDIR}

	oe_runmake -C "${S}"  ARCH=${ARCH} CROSS_COMPILE=${CROSS_COMPILE} KSRC=${STAGING_KERNEL_DIR} modules
}

do_install() {
	oe_runmake -C "${S}" DEPMOD=true KVER="${KERNEL_VERSION}" INSTALL_MOD_PATH="${D}" install

	install -p -m 755 -D "${S}/rtl8723bu_nic.bin" "${D}/lib/firmware/rtl_bt/"
	install -p -m 755 -D "${S}/rtl8723bu_bt.bin" "${D}/lib/firmware/rtl_bt/"
}

PACKAGES += "\
    kernel-module-8723bu \
    linux-firmware-rtl8723bu-bt \
    linux-firmware-rtl8723bu-nic \
"

FILES_kernel-module-8723bu += "/etc"
FILES_kernel-module-8723bu += "/lib/modules"
FILES_kernel-module-8723bu += "/lib/firmware/rtl_bt/rtl8723b_fw.bin"
FILES_linux-firmware-rtl8723bu-bt = "/lib/firmware/rtl_bt/rtl8723bu_bt.bin"
FILES_linux-firmware-rtl8723bu-nic = "/lib/firmware/rtl_bt/rtl8723bu_nic.bin"

KERNEL_MODULE_AUTOLOAD += "8723bu"
MACHINE_EXTRA_RRECOMMENDS += "kernel-module-8723bu linux-firmware-rtl8723bu-nic linux-firmware-rtl8723bu-bt"
