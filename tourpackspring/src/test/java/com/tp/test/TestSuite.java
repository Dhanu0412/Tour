package com.tp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class TestSuite.
 */
@RunWith(Suite.class)
@SuiteClasses(value = { CustomerTest.class, PackagesTest.class})
public class TestSuite {

}
