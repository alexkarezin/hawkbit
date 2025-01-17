/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.mgmt.rest.api;

import java.io.InputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A resource for download artifacts.
 */
@FunctionalInterface
// no request mapping specified here to avoid CVE-2021-22044 in Feign client
public interface MgmtDownloadRestApi {

    /**
     * Handles the GET request for downloading an artifact.
     * 
     * @param tenant
     *            the download belongs to
     * @param downloadId
     *            the generated download id
     * @param response
     *            of the servlet
     * @return {@link ResponseEntity} with status {@link HttpStatus#OK} if
     *         successful
     */
    @GetMapping(value = MgmtRestConstants.DOWNLOAD_ID_V1_REQUEST_MAPPING_BASE
            + MgmtRestConstants.DOWNLOAD_ID_V1_REQUEST_MAPPING)
    @ResponseBody
    ResponseEntity<InputStream> downloadArtifactByDownloadId(@PathVariable("tenant") String tenant,
            @PathVariable("downloadId") String downloadId);

}
