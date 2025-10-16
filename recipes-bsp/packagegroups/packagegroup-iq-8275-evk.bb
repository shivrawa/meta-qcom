SUMMARY = "Packages for the IQ-8275-EVK platform"

inherit packagegroup

PACKAGES = " \
    ${PN}-firmware \
"

RRECOMMENDS:${PN}-firmware = " \
    ${@bb.utils.contains_any('DISTRO_FEATURES', 'opencl opengl vulkan', 'linux-firmware-qcom-adreno-a623 linux-firmware-qcom-adreno-a650 linux-firmware-qcom-qcs8300-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath11k-wcn6855', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca-qca2066', '', d)} \
    linux-firmware-qcom-qcs8300-audio \
    linux-firmware-qcom-qcs8300-compute \
    linux-firmware-qcom-qcs8300-generalpurpose \
    linux-firmware-qcom-vpu \
"
