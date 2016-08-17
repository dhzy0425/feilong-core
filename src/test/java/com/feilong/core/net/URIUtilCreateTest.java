/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.net;

import java.net.URI;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.tools.jsonlib.JsonUtil;

import static com.feilong.core.CharsetType.UTF8;

/**
 * The Class URIUtilTest.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 */
public class URIUtilCreateTest{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(URIUtilCreateTest.class);
    //***************com.feilong.core.net.URIUtil.create(String)************************************************************************

    /**
     * Test create.
     */
    @Test
    public void testCreate(){
        String value = "http://xy2.cbg.163.com/cgi-bin/equipquery.py?server_name=风花雪月&query_order=selling_time DESC&search_page&areaid=2&server_id=63&act=search_browse&equip_type_ids&search_text=斩妖剑";
        value = "http://xy2.cbg.163.com/cgi-bin/equipquery.py?server_name=风花雪月&query_order=selling_time";
        URI uri = URIUtil.create(value);
        LOGGER.debug("{}", uri.toString());
    }

    /**
     * Test create3.
     */
    @Test
    public void testCreate3(){
        String uriString = "http://127.0.0.1/cmens?a=%";
        LOGGER.debug("" + URI.create(uriString));
    }

    /**
     * Test create2.
     */
    @Test
    public void testCreate2(){
        URI uri = URIUtil.create("http://127.0.0.1/cmens/t-b-f-a-c-s-f-p-g-e-i-o;a=2,4;p=3", UTF8);
        LOGGER.debug(JsonUtil.format(uri));
    }

    /**
     * Creates the.
     */
    @Test
    public void create(){
        String url = "http://127.0.0.1/cmens/t-b-f-a-c-s-f-p-g-e-i-o.htm?a=1&a=2";
        URI uri = URIUtil.create(url, UTF8);
        LOGGER.debug(uri.toString());
    }

    //****************************************************************************************
    /**
     * Test create null.
     */
    @Test(expected = NullPointerException.class)
    public void testCreateNull(){
        URIUtil.create(null);
    }

    /**
     * Test create empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateEmpty(){
        URIUtil.create("");
    }

    /**
     * Test create empty 1.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateEmpty1(){
        URIUtil.create(" ");
    }
}
