SRC_URI = "git://github.com/Scalys/linux-qoriq.git;protocol=git;branch=scalys-4.19"
SRCREV = "7bd6711b83e321ac29a178264f0f03505960acda"

DELTA_KERNEL_DEFCONFIG_append_qls1046a-4gb = " qls1046a-4gb.config"

# Insert fitImage into /boot/ folder of rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += " kernel-image kernel-devicetree"
