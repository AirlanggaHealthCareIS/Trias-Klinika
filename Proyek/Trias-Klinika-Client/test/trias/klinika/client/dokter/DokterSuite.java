/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.client.dokter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author iqbal
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({trias.klinika.client.dokter.input_resepTest.class, trias.klinika.client.dokter.form_pembayaranTest.class, trias.klinika.client.dokter.Menu_DokterTest.class, trias.klinika.client.dokter.Inventori_Obat_DokterTest.class, trias.klinika.client.dokter.datapasienTest.class, trias.klinika.client.dokter.UtamaDokterTest.class})
public class DokterSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}