SRC_URI = "git://github.com/Scalys/linux-qoriq.git;protocol=git;branch=scalys-4.19"
SRCREV = "62878711fb3a95e0a76b49df4c9512417a5a0d96"

DELTA_KERNEL_DEFCONFIG_append_qls1046a-4gb = " qls1046a-4gb.config"

# Insert fitImage into /boot/ folder of rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += " kernel-image kernel-devicetree"
