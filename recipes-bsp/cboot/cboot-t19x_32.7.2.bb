DESCRIPTION = "cboot bootloader for Tegra194"

SRC_URI = "${L4T_URI_BASE}/cboot_src_t19x.tbz2;downloadfilename=cboot_src_t19x-${PV}.tbz2;subdir=${BP} \
    file://0001-Drop-mistaken-global-variable-definition-in-sdmmc_de.patch \
    file://0002-Convert-Python-scripts-to-Python3.patch \
    file://0003-macros.mk-fix-GNU-make-4.3-compatibility.patch \
    file://0004-Restore-version-number-to-L4T-builds.patch \
    file://0005-Fix-spurious-console-none-warning.patch \
    file://0006-Add-bootinfo-module-definition-to-tegrabl_error.patch \
    file://0007-Add-bootinfo-module.patch \
    file://0008-t194-l4t.mk-make-some-build-options-configurable.patch \
    file://0009-tegrabl_cbo-support-A-B-slots.patch \
    file://0010-t194-add-bootinfo-to-build.patch \
    file://0011-Add-machine-ID-to-kernel-command-line.patch \
    file://0012-Restore-fallback-path-for-failed-extlinux-booting.patch \
    file://0013-Fix-ext4-sparse-file-handling.patch \
    file://0014-extlinux-support-timeouts-under-1-sec.patch \
    file://0015-Fix-ext4-multi-block-linear-directory-traversal.patch \
    file://0016-ext2-fix-symlink-support-in-ext2_dir_lookup.patch \
    file://0017-Support-A-B-slot-for-kernel-on-SDcards-and-USB-devic.patch \
"


SRC_URI[sha256sum] = "76e1105810bd5827facea9547e25bcc7a9cd4e1dda56a2b1c19c687b65c27f93"

PACKAGECONFIG ??= "bootdev-select ethernet display shell recovery extlinux"
PACKAGECONFIG[bootdev-select] = "CONFIG_ENABLE_BOOT_DEVICE_SELECT=1,,"
PACKAGECONFIG[ethernet] = "CONFIG_ENABLE_ETHERNET_BOOT=1,,"
PACKAGECONFIG[display] = "CONFIG_ENABLE_DISPLAY=1,,"
PACKAGECONFIG[shell] = "CONFIG_ENABLE_SHELL=1,,"
PACKAGECONFIG[recovery] = "CONFIG_ENABLE_L4T_RECOVERY=1,,"
PACKAGECONFIG[extlinux] = "CONFIG_ENABLE_EXTLINUX_BOOT=1,,"
PACKAGECONFIG[machine-id] = "CONFIG_ENABLE_MACHINE_ID=1,,"

# Xavier NX devkits *must* have this option, or they cannot boot from the SDcard:
EXTRA_GLOBAL_DEFINES:append:jetson-xavier-nx-devkit = " CONFIG_ENABLE_BOOT_DEVICE_SELECT=1"

TARGET_SOC = "t194"
COMPATIBLE_MACHINE = "(tegra194)"
PROVIDES += "virtual/bootloader"

L4T_VERSION = "32.7.2"
L4T_SRCS_NAME = "sources/T186"
require cboot-l4t.inc
