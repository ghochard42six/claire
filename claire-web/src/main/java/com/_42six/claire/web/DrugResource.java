package com._42six.claire.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com._42six.claire.commons.model.ChartDetail;
import com._42six.claire.commons.model.Drug;
import com._42six.claire.commons.model.DrugRankings;
import com._42six.claire.commons.model.FDAStats;
import com._42six.claire.commons.model.TwitterStats;

/**
 * Class to handle the Drug REST API endpoints
 */
@Path("drug")
@Singleton
public class DrugResource extends CommonResource {

	public DrugResource() throws JsonParseException, JsonMappingException, IOException, ParseException {
		super();
	}

	@GET
	@Path("/detail/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Drug getDrugDetails(@PathParam("drugName") String drugName) {
		return this.responseTranslator.getDrugDetails(drugName);
	}

	@GET
	@Path("/tweets/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public TwitterStats getTwitterStats(@PathParam("drugName") String drugName) {
		return this.responseTranslator.getTwitterStats(drugName);
	}

	@GET
	@Path("/fda/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public FDAStats getFDAStats(@PathParam("drugName") String drugName) {
		return this.responseTranslator.getFDAStats(drugName);
	}

	@GET
	@Path("/ranking/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public DrugRankings getDrugRanks(@PathParam("drugName") String drugName) {
		return this.responseTranslator.getDrugRank(drugName);
	}

	@GET
	@Path("/chart/{drugName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ChartDetail getChart(
			@PathParam("drugName") String drugName,
			@DefaultValue("100") @QueryParam("maxPercent") final Integer maxPercent
			) {
		return this.responseTranslator.getChart(drugName, maxPercent);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Drug> getDrugs() {
		return this.responseTranslator.getDrugs();
	}
}

