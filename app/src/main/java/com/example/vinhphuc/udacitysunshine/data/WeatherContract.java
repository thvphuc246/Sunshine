package com.example.vinhphuc.udacitysunshine.data;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.vinhphuc.udacitysunshine.utilities.SunshineDateUtils;

/**
 * Created by VINH PHUC on 19/3/2018.
 */

public class WeatherContract {
    public static final String CONTENT_AUTHORITY = "com.example.vinhphuc.udacitysunshine";
    public static final Uri BASE_CONTETNT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_WEATHER = "weather";

    public static final class WeatherEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTETNT_URI.buildUpon()
                .appendPath(PATH_WEATHER)
                .build();

        public static final String TABLE_NAME = "weather";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_WEATHER_ID = "weather_id";
        public static final String COLUMN_MIN_TEMP = "min";
        public static final String COLUMN_MAX_TEMP = "max";
        public static final String COLUMN_HUMIDITY = "humidity";
        public static final String COLUMN_PRESSURE = "pressure";
        public static final String COLUMN_WIND_SPEED = "wind";
        public static final String COLUMN_DEGREES = "degrees";

        public static Uri buildWeatherUriWithDate(long date) {
            return CONTENT_URI.buildUpon()
                    .appendPath(Long.toString(date))
                    .build();
        }

        public static String getSqlSelectForTodayOnwards() {
            long normalizedUtcNow = SunshineDateUtils.normalizeDate(System.currentTimeMillis());
            return WeatherEntry.COLUMN_DATE + " >= " + normalizedUtcNow;
        }
    }
}
