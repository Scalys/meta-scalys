#@TYPE: Machine
#@NAME: Teledyne QLS1046A-4GB on Scalys development board
#@SOC: LSCH2
#@DESCRIPTION: Machine configuration for running LS1046A in 64-bit mode
#@MAINTAINER: Zhenhua Luo <zhenhua.luo@nxp.com>
#@MAINTAINER: opensource@scalys.com

MACHINEOVERRIDES =. "fsl-lsch2:ls1046a:"

require conf/machine/include/qoriq-arm64.inc
require conf/machine/include/arm/arch-arm64.inc

MACHINE_FEATURES += "optee"

KERNEL_CLASSES  = " kernel-fitimage "
KERNEL_IMAGETYPES = "fitImage"

UBOOT_DTB_LOADADDRESS = "0x90000000"
UBOOT_ENTRYPOINT = "0x80080000"

UBOOT_CONFIG ??= "nor sdhc nor_xfi sdhc_xfi"
UBOOT_CONFIG[nor] = "qls1046a_4gb_ifc_nor_defconfig"
UBOOT_CONFIG[sdhc] = "qls1046a_4gb_sdcard_defconfig"
UBOOT_CONFIG[nor_xfi] = "qls1046a_4gb_ifc_nor_xfi_defconfig"
UBOOT_CONFIG[sdhc_xfi] = "qls1046a_4gb_sdcard_xfi_defconfig"

KERNEL_DEVICETREE ?= "\
    freescale/qls1046a-4gb.dtb \
    freescale/qls1046a-4gb-xfi.dtb \
    freescale/qls1046a-4gb-sdk.dtb \
    freescale/qls1046a-4gb-sdk-xfi.dtb \
"
KERNEL_DEFCONFIG ?= "defconfig"

SERIAL_CONSOLES ?= "115200;ttyS0 115200;ttyAMA0 115200;ttyLP0"
SERIAL_CONSOLES_CHECK ?= "${SERIAL_CONSOLES}"

RCWSD ?= "RR_SSSSPPPP_3333_8888/rcw_1600_sdboot"
RCWNOR ?= "RR_SSSSPPPP_3333_8888/rcw_1600_ifc_nor"
RCWSDXFI ?= "RR_FFSSPPPP_1133_8888/rcw_1600_sdboot_xfi"
RCWNORXFI ?= "RR_FFSSPPPP_1133_8888/rcw_1600_ifc_nor_xfi"
BOOTTYPE="nor sd nor_xfi sd_xfi"

FMAN_UCODE ?= "fsl_fman_ucode_ls1046_r1.0_106_4_18.bin"

EXTRA_IMAGEDEPENDS += "fm-ucode rcw qoriq-atf qe-ucode ls2-phy"
#DISTRO_FEATURES:append = " optee"
USE_VT = "0"

# Images types generated for this machine
IMAGE_FSTYPES:append = " tar.bz2 ubifs ubi wic"

# mkfs.ubi options:
# Find parameter values on target with `ubinfo -a`
#    -m, --min-io-size=SIZE   minimum I/O unit size
#    -e, --leb-size=SIZE      logical erase block size
#    -c, --max-leb-cnt=COUNT  maximum logical erase block count
MKUBIFS_ARGS = "--space-fixup -m 2048 -e 124KiB -c 10000"

# ubinize options:
# Find parameter values on target with `mtdinfo -a`
# -p, --peb-size=<bytes>       size of the physical eraseblock of the flash
# -m, --min-io-size=<bytes>    minimum input/output unit size of the flash in bytes
# -s, --sub-page-size=<bytes>  minimum input/output unit used for UBI headers
UBINIZE_ARGS = "-m 2048 -p 128KiB -s 2048"
UBI_VOLNAME = "rootfs"

WKS_FILES ?= "${MACHINE}-sdimg.wks"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS:append = " \
    kernel-image-fitimage \
"
