package org.borrow.backend.resources

import io.quarkus.test.junit.DisabledOnNativeImage
import io.quarkus.test.junit.NativeImageTest

@DisabledOnNativeImage
@NativeImageTest
class NativeLoginResourceIT : LoginResourceTest()