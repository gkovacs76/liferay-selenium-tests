/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.mytests.assertfilecontent;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portalweb.portal.BaseTestCase;

import com.liferay.portalweb.portal.util.TestPropsValues;

/**
 * @author Tibor Kovács
 */
public class EvaluateUserGmailUserTestCSVFileTest extends BaseTestCase {

	public void testEvaluateUserGmailUserTestCSVFile() throws Exception {
		assertTrue(evaluateUserGmailUserTestCSVFile());
	}

	private boolean evaluateUserGmailUserTestCSVFile() throws Exception {
		String fileName = TestPropsValues.OUTPUT_DIR + "users.csv";

		String xml = FileUtil.read(fileName);

		if (!xml.contains("Joe Bloggs,test@liferay.com")) {
			return false;
		}

		if (!xml.contains(
				"selen01 lenn nium01,liferay.qa.server.trunk2@gmail.com")) {

			return false;
		}

		if (xml.contains("selen02 lenn nium02,test02@selenium.com")) {
			return false;
		}

		if (!xml.contains("userfn userln,liferay.qa.server.trunk@gmail.com")) {

			return false;
		}
		return true;
	}

}