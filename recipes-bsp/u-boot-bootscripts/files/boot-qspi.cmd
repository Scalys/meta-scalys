pfe stop
ubi part UBI
ubifsmount ubi0:boot
ubifsload $kernel_addr_r /boot/fitImage
setenv bootargs "console=ttyS0,115200 earlycon=uart8250,mmio,0x21c0500 lpj=250000 noinitrd ubi.mtd=4 root=ubi0:boot rootfstype=ubifs rw rootwait $mtdparts"
bootm $kernel_addr_r
