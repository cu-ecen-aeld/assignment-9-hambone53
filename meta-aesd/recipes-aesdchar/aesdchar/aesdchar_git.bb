# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit module

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignments-3-and-later-hambone53.git;protocol=ssh;branch=main"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "73c63fc32ec9ad95d8ec99bb5d114577d51d91c1"

S = "${WORKDIR}/git/aesd-char-driver"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES:${PN} += "kernel-module-aesdchar"

#inherit update-rc.d
#INITSCRIPT_PACKAGES = "${PN}"
#INITSCRIPT_NAME:${PN} = "aesdchar-start-stop.sh"

# Add the startup script to the list of files to be packaged.  Any files
# that are installed but not packaged will cause a warning to be printed
# during the bitbake process.
#FILES:${PN} += "/etc/init.d/*"

#do_install () {
#    install -d ${D}${sysconfdir}/init.d
#	install -m 0755 ${S}/aesdchar-start-stop.sh ${D}${sysconfdir}/init.d
#}

