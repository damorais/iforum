package br.edu.ifsp.lp2a4.iforum.e2e.steps.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;

public class ResponseResults {
	private final ClientHttpResponse theResponse;
    private final String body;

    @SuppressWarnings("deprecation")
	ResponseResults(final ClientHttpResponse response) throws IOException {
        this.theResponse = response;
        final InputStream bodyInputStream = response.getBody();
        final StringWriter stringWriter = new StringWriter();
        IOUtils.copy(bodyInputStream, stringWriter);
        this.body = stringWriter.toString();
    }

    public ClientHttpResponse getTheResponse() {
        return theResponse;
    }

    public String getBody() {
        return body;
    }

}
