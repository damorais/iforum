package br.edu.ifsp.lp2a4.iforum.e2e.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.http.HttpStatus;

import br.edu.ifsp.lp2a4.iforum.e2e.steps.utils.SpringIntegrationTestHelpers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VersionSteps extends SpringIntegrationTestHelpers  {
	
	@When("the client calls \\\\/version")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet(getUrlForPath("/version"));
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("the client receives server version {string}")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

}
