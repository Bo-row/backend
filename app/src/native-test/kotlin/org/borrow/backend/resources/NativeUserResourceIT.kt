package org.borrow.backend.resources

import io.quarkus.test.junit.DisabledOnNativeImage
import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
@DisabledOnNativeImage
class NativeUserResourceIT : UserResourceTest()