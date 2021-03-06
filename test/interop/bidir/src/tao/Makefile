#----------------------------------------------------------------------------
#
# Makefile,v 1.90 2001/09/18 20:14:07 coryan Exp
#
#----------------------------------------------------------------------------

#----------------------------------------------------------------------------
#       Local macros
#----------------------------------------------------------------------------

ifndef TAO_ROOT
  TAO_ROOT = $(ACE_ROOT)/TAO
endif # ! TAO_ROOT

LDLIBS = -lTAO_BiDirGIOP -lTAO_CosNaming -lTAO_Svc_Utils -lTAO_IORTable -lTAO_PortableServer -lTAO

IDL_FILES = BiDirTest
IDL_SRC = BiDirTestC.cpp BiDirTestS.cpp

PROG_SRCS = \
        client.cpp \
        server.cpp \
        BiDirTest_i.cpp \

SRC = $(IDL_SRC) $(PROG_SRCS)

SIMPLE_CLT_OBJS = \
                BiDirTestC.o \
                BiDirTestS.o \
		BiDirTest_i.o \
                client.o
SIMPLE_SVR_OBJS = \
                BiDirTestC.o \
                BiDirTestS.o \
                BiDirTest_i.o \
                server.o

BIN2 = server \
       client

#### If the TAO orbsvcs library wasn't built with sufficient components,
#### don't try to build here.
TAO_ORBSVCS := $(shell sh $(ACE_ROOT)/bin/ace_components --orbsvcs)
ifeq (Naming,$(findstring Naming,$(TAO_ORBSVCS)))
  BIN = $(BIN2)
endif # Naming

TAO_IDLFLAGS += -Ge 1
#----------------------------------------------------------------------------
#       Include macros and targets
#----------------------------------------------------------------------------

include $(ACE_ROOT)/include/makeinclude/wrapper_macros.GNU
include $(ACE_ROOT)/include/makeinclude/macros.GNU
include $(TAO_ROOT)/rules.tao.GNU
include $(ACE_ROOT)/include/makeinclude/rules.common.GNU
include $(ACE_ROOT)/include/makeinclude/rules.nonested.GNU
include $(ACE_ROOT)/include/makeinclude/rules.local.GNU
include $(TAO_ROOT)/taoconfig.mk

#----------------------------------------------------------------------------
#       Local targets
#----------------------------------------------------------------------------

LDFLAGS +=  -L$(TAO_ROOT)/tao -L$(ACE_ROOT)/ace
CPPFLAGS += -I$(TAO_ROOT)/orbsvcs

.PRECIOUS: BiDirTestC.cpp BiDirTestC.i BiDirTestC.h
.PRECIOUS: BiDirTestS.cpp BiDirTestS.i BiDirTestS.h
.PRECIOUS: BiDirTestS_T.cpp BiDirTestS_T.i BiDirTestS_T.h

server: $(addprefix $(VDIR),$(SIMPLE_SVR_OBJS))
	$(LINK.cc) $(LDFLAGS) -o $@ $^ $(VLDLIBS) $(POSTLINK)

client: $(addprefix $(VDIR),$(SIMPLE_CLT_OBJS))
	$(LINK.cc) $(LDFLAGS) -o $@ $^ $(VLDLIBS) $(POSTLINK)

realclean: clean
	-$(RM) -rf BiDirTestC.* BiDirTestS.* BiDirTestS_T.*

#----------------------------------------------------------------------------
#       Dependencies
#----------------------------------------------------------------------------

# DO NOT DELETE THIS LINE -- g++dep uses it.
# DO NOT PUT ANYTHING AFTER THIS LINE, IT WILL GO AWAY.

# IF YOU PUT ANYTHING HERE IT WILL GO AWAY




