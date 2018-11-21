package Logica;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Arrays;

public class SMS {

	public static void send(String num, String msg) {

		List<String> usrs = Arrays.asList(new String[] { "ZEROBOY","NISE_CHA", "NISE_AL", "NISE_NAT", "NISE_TEM", "NISE_YAN",
				"NISE_SER", "NISE_CRA", "NISE-YU", "NISE_NI" , "NO_REPLY_NISE", "NISE_ALEJ", "NISE_JU",
				"NISE_UHC", "NISE_WIL" });
		int cont = 0;
		String status = "25";
		while (status.startsWith("25")) {

			status = sendMSM(num, msg,usrs.get(cont));
			System.out.println(status +"---"+ usrs.get(cont)+" ---");
			cont++;
		}

	}

	public static String sendMSM(String num, String msg, String usr) {
		String resSTATUS = "25";
		try {
			// Construct data
			String data = "";
			/*
			 * Note the suggested encoding for certain parameters, notably the username,
			 * password and especially the message. ISO-8859-1 is essentially the character
			 * set that we use for message bodies, with a few exceptions for e.g. Greek
			 * characters. For a full list, see:
			 * http://developer.bulksms.com/eapi/submission/character-encoding/
			 */
			data += "username=" + URLEncoder.encode(usr + "", "ISO-8859-1");
			data += "&password=" + URLEncoder.encode("nise123456", "ISO-8859-1");
			data += "&message=" + URLEncoder.encode(msg, "ISO-8859-1");
			data += "&want_report=1";
			data += "&msisdn=" + num;

			// Send data
			// Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
			URL url = new URL("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;

			while ((line = rd.readLine()) != null) {
				// Print the response output...
				System.out.println(line);
				resSTATUS = line;
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resSTATUS;
	}
}
