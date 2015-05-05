package com.arg1arg2.test.JFXDataTag;

import java.io.IOException;
import java.net.URL;

import com.arg1arg2.jfx.Data;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by grmartin on 5/5/15.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) /* i should use a suite but im lazy */
public class ValidDataTagWithAttributesTests {
    private static Data LOOKUP_NODE;
    private static Node DOCUMENT_NODE;
    private static URL RESOURCE_URL;

    @BeforeClass
    public static void setup() throws IOException {
        RESOURCE_URL = ValidDataTagWithAttributesTests.class.getClassLoader().getResource("valid-data-tag-attrs.fxml");

        assert RESOURCE_URL != null;

        DOCUMENT_NODE = FXMLLoader.load(RESOURCE_URL);

        assert DOCUMENT_NODE != null;
    }

    @Test
    public void test01_canFindNodeTest() {
        assert  DOCUMENT_NODE.lookup("#lookup_id") != null;

        LOOKUP_NODE = (Data) DOCUMENT_NODE.lookup("#lookup_id");
    }

    @Test
    public void test02_hasValidKeyCountTest() { /* The fx:id tag is EXPECTED to be consumed by the loader, infact all fx: NS Prefixed items likely will be */
        assert LOOKUP_NODE.size() == 6;
    }
}
