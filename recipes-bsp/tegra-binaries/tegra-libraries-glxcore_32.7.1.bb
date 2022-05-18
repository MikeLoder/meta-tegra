L4T_DEB_COPYRIGHT_MD5 = "ce4d36df31e6cc73581fd2a25d16834e"
DEPENDS = "tegra-libraries-core tegra-libraries-eglcore libx11 libxext freetype fontconfig"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-3d-core"

require tegra-debian-libraries-common.inc

MAINSUM = "ef33408256a85a638c06c03683bb62a5d594ba4f5241763510cf23fbb43a2b47"
MAINSUM_tegra210 = "70fa171acb7f6203ffbb4adcf239132e5dccf0b759b09009bced3599fc1970c0"

inherit features_check

REQUIRED_DISTRO_FEATURES = "x11"

TEGRA_LIBRARIES_TO_INSTALL = "\
    tegra/libGLX_nvidia.so.0 \
    tegra/libnvidia-glcore.so.${L4T_VERSION} \
"

# This package includes files that were moved from tegra-libraries so we need to mark it as a conflict
# to have a successful apt upgrade.
RREPLACES_${PN} = "tegra-libraries"
RCONFLICTS_${PN} = "tegra-libraries"
