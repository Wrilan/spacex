import org.nd4j.shade.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Launch {

private int flight_number;
private String mission_name;
private String[] mission_id;
private boolean upcoming;
private String launch_year;
private Date launch_date_unix;
private String launch_date_utc;
private String launch_date_local;
private boolean is_tentative;
private String tentative_max_precision;
private boolean tbd;
private int launch_window;
private Object rocket;
private String[] ships;
private Object telemetry;
private Object launch_site;
private boolean launch_success;
private Object launch_failure_details;
private Links links;
private String details;
private String static_fire_date_utc;
private Date static_fire_date_unix;
private Object timeline;

    public int getFlight_number() {
        return flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public String[] getMission_id() {
        return mission_id;
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public Date getLaunch_date_unix() {
        return launch_date_unix;
    }

    public String getLaunch_date_utc() {
        return launch_date_utc;
    }

    public String getLaunch_date_local() {
        return launch_date_local;
    }

    public boolean isIs_tentative() {
        return is_tentative;
    }

    public String getTentative_max_precision() {
        return tentative_max_precision;
    }

    public boolean isTbd() {
        return tbd;
    }

    public int getLaunch_window() {
        return launch_window;
    }

    public Object getRocket() {
        return rocket;
    }

    public String[] getShips() {
        return ships;
    }

    public Object getTelemetry() {
        return telemetry;
    }

    public Object getLaunch_site() {
        return launch_site;
    }

    public boolean isLaunch_success() {
        return launch_success;
    }

    public Object getLaunch_failure_details() {
        return launch_failure_details;
    }

    public Links getLinks() {
        return links;
    }

    public String getDetails() {
        return details;
    }

    public String getStatic_fire_date_utc() {
        return static_fire_date_utc;
    }

    public Date getStatic_fire_date_unix() {
        return static_fire_date_unix;
    }

    public Object getTimeline() {
        return timeline;
    }
}
