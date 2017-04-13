package org.cdc.gov.sdp;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class Transformer implements Processor {
	public void process(Exchange exchange) throws Exception {
        Map myMap = exchange.getIn().getBody(Map.class);
        Message msg = exchange.getIn();
        msg.setHeader("SOURCE_HEADERS", myMap);
        msg.setBody(myMap.get("payloadTextContent"));
        msg.setHeader("SOURCE", "PHINMS");
        msg.setHeader("SOURCE_ID", myMap.get("recordId"));
        msg.setHeader("ID", "PHINMS_"+myMap.get("recordId"));
        msg.setHeader("SENDER", myMap.get("fromPartyId"));
        msg.setHeader("RECIPIENT", myMap.get("recipientId"));
        
    }
}
