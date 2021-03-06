cmake_minimum_required(VERSION 3.1.0)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED on)

# Define project and related variables
project(tpu)
set(PROJECT_VERSION_MAJOR 0)
set(PROJECT_VERSION_MINOR 2)
set(PROJECT_VERSION_PATCH 0)

# Include directories
include_directories(.)
include_directories(./include)
include_directories(./ops)

# Needed for the TensorFlow header files.
include_directories(../../../../jni/src/main/native/include)
include_directories(../../../../../../jni/src/main/native/include)
include_directories(/tensorflow_scala/jni/src/main/native/include)

# Find Native TensorFlow Library to link
find_library(LIB_TENSORFLOW tensorflow HINTS ENV LD_LIBRARY_PATH)
if(NOT LIB_TENSORFLOW)
  message(FATAL_ERROR "Library `tensorflow` not found.")
endif()

find_library(LIB_TENSORFLOW_FRAMEWORK tensorflow_framework HINTS ENV LD_LIBRARY_PATH)
if(NOT LIB_TENSORFLOW_FRAMEWORK)
  message(FATAL_ERROR "Library `tensorflow_framework` not found.")
endif()

# Collect sources for the op library

file(GLOB OPS_LIB_SRC
  "*.cc"
  "include/tensorflow/contrib/tpu/proto/*.cc"
  "ops/*.cc"
)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -D_GLIBCXX_USE_CXX11_ABI=0")

set(CMAKE_BUILD_WITH_INSTALL_RPATH 1)
if(${APPLE})
    set(CMAKE_INSTALL_RPATH "@loader_path")
    set(CMAKE_INSTALL_NAME_DIR "@loader_path")
else()
    set(CMAKE_INSTALL_RPATH "$ORIGIN/")
endif()

# Setup installation targets
set(OPS_LIB_NAME "${PROJECT_NAME}_ops")
add_library(${OPS_LIB_NAME} MODULE ${OPS_LIB_SRC})
target_link_libraries(${OPS_LIB_NAME} ${LIB_TENSORFLOW} ${LIB_TENSORFLOW_FRAMEWORK})
install(TARGETS ${OPS_LIB_NAME} LIBRARY DESTINATION .)
