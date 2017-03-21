package com.craigstockton.teksystems.state.service;

import com.craigstockton.teksystems.state.data.StateInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class StateInfoResponse {
    public final static Integer SUCCESS = 200;
    private final static String BEGIN_STATE_DATA = "[ {\n      \"country\"";
    private final static String END_STATE_DATA = "]";
    private final String body;
    private Integer status;

    private StateInfoResponse(Response response) {
//        this.status = response.getStatus();
        this.status = 200;
        this.body = "{\n" + "  \"RestResponse\" : {\n" + "    \"messages\" : [ \"More webservices are available at "
                + "http://www.groupkt.com/post/f2129b88/services.htm\", \"Total [56] records found.\" ],\n" + "    "
                + "\"result\" : [ {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : \"Alabama\",\n" + "    " +
                "  " + "\"abbr\" : \"AL\",\n" + "      \"area\" : \"135767SKM\",\n" + "      \"largest_city\" : " +
                "\"Birmingham\",\n" + "      \"capital\" : \"Montgomery\"\n" + "    }, {\n" + "      \"country\" : "
                + "\"USA\",\n" + "      \"name\" : \"Alaska\",\n" + "      \"abbr\" : \"AK\",\n" + "      \"area\" : " +
                "" + "\"1723337SKM\",\n" + "      \"largest_city\" : \"Anchorage\",\n" + "      \"capital\" : " +
                "\"Juneau\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : \"Arizona\",\n"
                + "      \"abbr\" : \"AZ\",\n" + "      \"area\" : \"294207SKM\",\n" + "      \"capital\" : " +
                "\"Phoenix\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : \"Arkansas\","
                + "\n" + "      \"abbr\" : \"AR\",\n" + "      \"area\" : \"134770SKM\",\n" + "      \"capital\" : "
                + "\"Little Rock\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : " +
                "\"California\",\n" + "      \"abbr\" : \"CA\",\n" + "      \"area\" : \"423968SKM\",\n" + "      " +
                "\"largest_city\" : \"Los Angeles\",\n" + "      \"capital\" : \"Sacramento\"\n" + "    }, {\n" + "  " +
                "" + "    \"country\" : \"USA\",\n" + "      \"name\" : \"Colorado\",\n" + "      \"abbr\" : \"CO\"," +
                "\n" + "      \"area\" : \"268432SKM\",\n" + "      \"capital\" : \"Denver\"\n" + "    }, {\n" + "   " +
                "   " + "\"country\" : \"USA\",\n" + "      \"name\" : \"Connecticut\",\n" + "      \"abbr\" : " +
                "\"CT\",\n" + "" + "      \"area\" : \"14356SKM\",\n" + "      \"largest_city\" : \"Bridgeport\",\n"
                + "      " + "\"capital\" : \"Hartford\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "    " +
                "  \"name\" : " + "\"Delaware\",\n" + "      \"abbr\" : \"DE\",\n" + "      \"area\" : \"6446SKM\"," +
                "\n" + "      " + "\"largest_city\" : \"Wilmington\",\n" + "      \"capital\" : \"Dover\"\n" + "    " +
                "}, {\n" + "      " + "\"country\" : \"USA\",\n" + "      \"name\" : \"Florida\",\n" + "      " +
                "\"abbr\" : \"FL\",\n" + "    " + "  \"area\" : \"170312SKM\",\n" + "      \"largest_city\" : " +
                "\"Jacksonville\",\n" + "      \"capital\"" + " : \"Tallahassee\"\n" + "    }, {\n" + "      " +
                "\"country\" : \"USA\",\n" + "      \"name\" : " + "\"Georgia\",\n" + "      \"abbr\" : \"GA\",\n" +
                "      \"area\" : \"148958SKM\",\n" + "      " + "\"capital\" : \"Atlanta\"\n" + "    }, {\n" + "    " +
                "  \"country\" : \"USA\",\n" + "      \"name\" : " + "\"Hawaii\",\n" + "      \"abbr\" : \"HI\",\n" +
                "      \"area\" : \"16635SKM\",\n" + "      " + "\"capital\" : \"Honolulu\"\n" + "    }, {\n" + "    " +
                "  \"country\" : \"USA\",\n" + "      \"name\" : " + "\"Idaho\",\n" + "      \"abbr\" : \"ID\",\n" +
                "      \"area\" : \"214044SKM\",\n" + "      " + "\"capital\" : \"Boise\"\n" + "    }, {\n" + "      " +
                "\"country\" : \"USA\",\n" + "      \"name\" : " + "\"Illinois\",\n" + "      \"abbr\" : \"IL\",\n" +
                "      \"area\" : \"149997SKM\",\n" + "      " + "\"largest_city\" : \"Chicago\",\n" + "      " +
                "\"capital\" : \"Springfield\"\n" + "    }, {\n" + "     " + " \"country\" : \"USA\",\n" + "      " +
                "\"name\" : \"Indiana\",\n" + "      \"abbr\" : \"IN\",\n" + "   " + "   \"area\" : \"92789SKM\",\n"
                + "      \"capital\" : \"Indianapolis\"\n" + "    }, {\n" + "      " + "\"country\" : \"USA\",\n" + "" +
                "      \"name\" : \"Iowa\",\n" + "      \"abbr\" : \"IA\",\n" + "      " + "\"area\" : \"144669SKM\"," +
                "\n" + "      \"capital\" : \"Des Moines\"\n" + "    }, {\n" + "      " + "\"country\" : \"USA\",\n"
                + "      \"name\" : \"Kansas\",\n" + "      \"abbr\" : \"KS\",\n" + "     " + " \"area\" : " +
                "\"213099SKM\",\n" + "      \"largest_city\" : \"Wichita\",\n" + "      \"capital\" : " +
                "\"Topeka\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : \"Kentucky\",\n"
                + "      \"abbr\" : \"KY\",\n" + "      \"area\" : \"104656SKM\",\n" + "      \"largest_city\" : " +
                "\"Louisville\",\n" + "      \"capital\" : \"Frankfort\"\n" + "    }, {\n" + "      \"country\" : " +
                "\"USA\",\n" + "      \"name\" : \"Louisiana\",\n" + "      \"abbr\" : \"LA\",\n" + "      \"area\" " +
                ":" + " \"135658SKM\",\n" + "      \"largest_city\" : \"New Orleans\",\n" + "      \"capital\" : " +
                "\"Baton " + "Rouge\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : " +
                "\"Maine\",\n" + "  " + "    \"abbr\" : \"ME\",\n" + "      \"area\" : \"91634SKM\",\n" + "      " +
                "\"largest_city\" : " + "\"Portland\",\n" + "      \"capital\" : \"Augusta\"\n" + "    }, {\n" + "   " +
                "   \"country\" : " + "\"USA\",\n" + "      \"name\" : \"Maryland\",\n" + "      \"abbr\" : \"MD\"," +
                "\n" + "      \"area\" : " + "\"32131SKM\",\n" + "      \"largest_city\" : \"Baltimore\",\n" + "     " +
                " \"capital\" : " + "\"Annapolis\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      " +
                "\"name\" : " + "\"Massachusetts\",\n" + "      \"abbr\" : \"MA\",\n" + "      \"area\" : " +
                "\"20202SKM\",\n" + "      " + "\"capital\" : \"Boston\"\n" + "    }, {\n" + "      \"country\" : " +
                "\"USA\",\n" + "      \"name\" : " + "\"Michigan\",\n" + "      \"abbr\" : \"MI\",\n" + "      " +
                "\"area\" : \"250488SKM\",\n" + "      " + "\"largest_city\" : \"Detroit\",\n" + "      \"capital\" :" +
                " \"Lansing\"\n" + "    }, {\n" + "      " + "\"country\" : \"USA\",\n" + "      \"name\" : " +
                "\"Minnesota\",\n" + "      \"abbr\" : \"MN\",\n" + "  " + "    \"area\" : \"225163SKM\",\n" + "     " +
                " \"largest_city\" : \"Minneapolis\",\n" + "      " + "\"capital\" : \"St. Paul\"\n" + "    }, {\n" +
                "      \"country\" : \"USA\",\n" + "      \"name\" : " + "\"Mississippi\",\n" + "      \"abbr\" : " +
                "\"MS\",\n" + "      \"area\" : \"121530SKM\",\n" + "      " + "\"capital\" : \"Jackson\"\n" + "    " +
                "}, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : " + "\"Missouri\",\n" + "      " +
                "\"abbr\" : \"MO\",\n" + "      \"area\" : \"180540SKM\",\n" + "      " + "\"largest_city\" : " +
                "\"Kansas City\",\n" + "      \"capital\" : \"Jefferson City\"\n" + "    }, {\n" + "      \"country\"" +
                " : \"USA\",\n" + "      \"name\" : \"Montana\",\n" + "      \"abbr\" : \"MT\",\n" + "      \"area\" " +
                ": \"380832SKM\",\n" + "      \"largest_city\" : \"Billings\",\n" + "      \"capital\"" + " : " +
                "\"Helena\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : \"Nebraska\"," +
                "\n" + "      \"abbr\" : \"NE\",\n" + "      \"area\" : \"200330SKM\",\n" + "      \"largest_city\" " +
                ":" + " \"Omaha\",\n" + "      \"capital\" : \"Lincoln\"\n" + "    }, {\n" + "      \"country\" : " +
                "\"USA\"," + "\n" + "      \"name\" : \"Nevada\",\n" + "      \"abbr\" : \"NV\",\n" + "      \"area\"" +
                " : " + "\"286380SKM\",\n" + "      \"largest_city\" : \"Las Vegas\",\n" + "      \"capital\" : " +
                "\"Carson " + "City\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : \"New " +
                "Hampshire\"," + "\n" + "      \"abbr\" : \"NH\",\n" + "      \"area\" : \"24214SKM\",\n" + "      " +
                "\"largest_city\" : " + "\"Manchester\",\n" + "      \"capital\" : \"Concord\"\n" + "    }, {\n" + " " +
                "     \"country\" : " + "\"USA\",\n" + "      \"name\" : \"New Jersey\",\n" + "      \"abbr\" : " +
                "\"NJ\",\n" + "      \"area\" " + ": \"22592SKM\",\n" + "      \"largest_city\" : \"Newark\",\n" + " " +
                "     \"capital\" : \"Trenton\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      " +
                "\"name\" : \"New Mexico\",\n" + "      " + "\"abbr\" : \"NM\",\n" + "      \"area\" : \"314917SKM\"," +
                "\n" + "      \"largest_city\" : " + "\"Albuquerque\",\n" + "      \"capital\" : \"Santa Fe\"\n" + " " +
                "   }, {\n" + "      \"country\" : " + "\"USA\",\n" + "      \"name\" : \"New York\",\n" + "      " +
                "\"abbr\" : \"NY\",\n" + "      \"area\" : " + "\"141297SKM\",\n" + "      \"largest_city\" : \"New " +
                "York City\",\n" + "      \"capital\" : " + "\"Albany\"\n" + "    }, {\n" + "      \"country\" : " +
                "\"USA\",\n" + "      \"name\" : \"North " + "Carolina\",\n" + "      \"abbr\" : \"NC\",\n" + "      " +
                "\"area\" : \"139391SKM\",\n" + "      " + "\"largest_city\" : \"Charlotte\",\n" + "      \"capital\"" +
                " : \"Raleigh\"\n" + "    }, {\n" + "      " + "\"country\" : \"USA\",\n" + "      \"name\" : \"North" +
                " Dakota\",\n" + "      \"abbr\" : \"ND\",\n" + "      \"area\" : \"183107SKM\",\n" + "      " +
                "\"largest_city\" : \"Fargo\",\n" + "      \"capital\" : " + "\"Bismarck\"\n" + "    }, {\n" + "     " +
                " \"country\" : \"USA\",\n" + "      \"name\" : \"Ohio\",\n" + "      \"abbr\" : \"OH\",\n" + "      " +
                "\"area\" : \"105830SKM\",\n" + "      \"capital\" : " + "\"Columbus\"\n" + "    }, {\n" + "      " +
                "\"country\" : \"USA\",\n" + "      \"name\" : \"Oklahoma\"," + "\n" + "      \"abbr\" : \"OK\",\n" +
                "      \"area\" : \"177660SKM\",\n" + "      \"capital\" : " + "\"Oklahoma City\"\n" + "    }, {\n" +
                "      \"country\" : \"USA\",\n" + "      \"name\" : " + "\"Oregon\",\n" + "      \"abbr\" : \"OR\"," +
                "\n" + "      \"area\" : \"254800SKM\",\n" + "      " + "\"largest_city\" : \"Portland\",\n" + "     " +
                " \"capital\" : \"Salem\"\n" + "    }, {\n" + "      " + "\"country\" : \"USA\",\n" + "      \"name\"" +
                " : \"Pennsylvania\",\n" + "      \"abbr\" : \"PA\",\n" + "      \"area\" : \"119279SKM\",\n" + "    " +
                "  \"largest_city\" : \"Philadelphia\",\n" + "      " + "\"capital\" : \"Harrisburg\"\n" + "    }, " +
                "{\n" + "      \"country\" : \"USA\",\n" + "      \"name\" " + ": \"Rhode Island\",\n" + "      " +
                "\"abbr\" : \"RI\",\n" + "      \"area\" : \"2678SKM\",\n" + "      " + "\"capital\" : " +
                "\"Providence\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" " + ": \"South" +
                " Carolina\",\n" + "      \"abbr\" : \"SC\",\n" + "      \"area\" : \"77858SKM\",\n" + "    " + "  " +
                "\"capital\" : \"Columbia\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" "
                + ": \"South Dakota\",\n" + "      \"abbr\" : \"SD\",\n" + "      \"area\" : \"199730SKM\",\n" + "   " +
                "  " + " \"largest_city\" : \"Sioux Falls\",\n" + "      \"capital\" : \"Pierre\"\n" + "    }, {\n" +
                "     " + " \"country\" : \"USA\",\n" + "      \"name\" : \"Tennessee\",\n" + "      \"abbr\" : " +
                "\"TN\",\n" + " " + "     \"area\" : \"109152SKM\",\n" + "      \"largest_city\" : \"Memphis\",\n" +
                "      \"capital\" :" + " \"Nashville\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "     " +
                " \"name\" : \"Texas\"," + "\n" + "      \"abbr\" : \"TX\",\n" + "      \"area\" : \"695660SKM\",\n"
                + "      \"largest_city\" :" + " \"Houston\",\n" + "      \"capital\" : \"Austin\"\n" + "    }, {\n"
                + "      \"country\" : \"USA\"," + "\n" + "      \"name\" : \"Utah\",\n" + "      \"abbr\" : \"UT\"," +
                "\n" + "      \"area\" : " + "\"212819SKM\",\n" + "      \"capital\" : \"Salt Lake City\"\n" + "    " +
                "}, {\n" + "      \"country\" :" + " \"USA\",\n" + "      \"name\" : \"Vermont\",\n" + "      " +
                "\"abbr\" : \"VT\",\n" + "      \"area\" : " + "\"24905SKM\",\n" + "      \"largest_city\" : " +
                "\"Burlington\",\n" + "      \"capital\" : " + "\"Montpelier\"\n" + "    }, {\n" + "      \"country\"" +
                " : \"USA\",\n" + "      \"name\" : " + "\"Virginia\",\n" + "      \"abbr\" : \"VA\",\n" + "      " +
                "\"area\" : \"110787SKM\",\n" + "      " + "\"largest_city\" : \"Virginia Beach\",\n" + "      " +
                "\"capital\" : \"Richmond\"\n" + "    }, {\n" + " " + "     \"country\" : \"USA\",\n" + "      " +
                "\"name\" : \"Washington\",\n" + "      \"abbr\" : \"WA\",\n" + "      \"area\" : \"184661SKM\",\n" +
                "      \"largest_city\" : \"Seattle\",\n" + "      " + "\"capital\" : \"Olympia\"\n" + "    }, {\n" +
                "      \"country\" : \"USA\",\n" + "      \"name\" : " + "\"West Virginia\",\n" + "      \"abbr\" : " +
                "\"WV\",\n" + "      \"area\" : \"62258SKM\",\n" + "      " + "\"capital\" : \"Charleston\"\n" + "   " +
                " }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" " + ": \"Wisconsin\",\n" + "      " +
                "\"abbr\" : \"WI\",\n" + "      \"area\" : \"169634SKM\",\n" + "      " + "\"largest_city\" : " +
                "\"Milwaukee\",\n" + "      \"capital\" : \"Madison\"\n" + "    }, {\n" + "      " + "\"country\" : " +
                "\"USA\",\n" + "      \"name\" : \"Wyoming\",\n" + "      \"abbr\" : \"WY\",\n" + "    " + "  " +
                "\"area\" : \"251470SKM\",\n" + "      \"capital\" : \"Cheyenne\"\n" + "    }, {\n" + "      " +
                "\"country\" : \"USA\",\n" + "      \"name\" : \"District of Columbia\",\n" + "      \"abbr\" : " +
                "\"DC\",\n" + "      \"area\" : \"18SKM\"\n" + "    }, {\n" + "      \"country\" : \"USA\",\n" + "   " +
                "" + "   \"name\" : \"American Samoa\",\n" + "      \"abbr\" : \"AS\",\n" + "      \"area\" : " +
                "\"1505SKM\"," + "\n" + "      \"largest_city\" : \"April 17, 1900\",\n" + "      \"capital\" : " +
                "\"Pago Pago\"\n" + "  " + "  }, {\n" + "      \"country\" : \"USA\",\n" + "      \"name\" : " +
                "\"Guam\",\n" + "      \"abbr\" : " + "\"GU\",\n" + "      \"area\" : \"1479SKM\",\n" + "      " +
                "\"largest_city\" : \"April 11, 1899\",\n" + "      \"capital\" : \"Hagåtña\"\n" + "    }, {\n" + "  " +
                "    \"country\" : \"USA\",\n" + "      " + "\"name\" : \"Northern Mariana Islands\",\n" + "      " +
                "\"abbr\" : \"MP\",\n" + "      \"area\" : " + "\"5118SKM\",\n" + "      \"largest_city\" : " +
                "\"November 3, 1986[15]\",\n" + "      \"capital\" : " + "\"Saipan\"\n" + "    }, {\n" + "      " +
                "\"country\" : \"USA\",\n" + "      \"name\" : \"Puerto Rico\"," + "\n" + "      \"abbr\" : \"PR\"," +
                "\n" + "      \"area\" : \"13792SKM\",\n" + "      \"largest_city\" : " + "\"April 11, 1899\",\n" + "" +
                "      \"capital\" : \"San Juan\"\n" + "    }, {\n" + "      \"country\" : " + "\"USA\",\n" + "      " +
                "\"name\" : \"U.S. Virgin Islands\",\n" + "      \"abbr\" : \"VI\",\n" + "      " + "\"area\" : " +
                "\"1898SKM\",\n" + "      \"largest_city\" : \"March 31, 1917[26]\",\n" + "      " + "\"capital\" : " +
                "\"Charlotte Amalie\"\n" + "    } ]\n" + "  }\n" + "}";
//        this.body = response.readEntity(String.class);
    }

    static StateInfoResponse getInstance(Response response) {
        return new StateInfoResponse(response);
    }

    @SuppressWarnings("SpellCheckingInspection")
    public List<StateInfo> getStateInfos() {
        //noinspection ConstantConditions
        if (!status.equals(SUCCESS) || !body.contains(BEGIN_STATE_DATA)) {
            return new ArrayList<>();
        }
        int resultBeginIndex = body.indexOf(BEGIN_STATE_DATA);
        int resultEndIndex = body.lastIndexOf(END_STATE_DATA) + 1;
        String result = body.substring(resultBeginIndex, resultEndIndex);
        return new Gson().fromJson(result, new TypeToken<List<StateInfo>>() {
        }.getType());
    }

    public Integer getStatus() {
        return status;
    }
}
