package net.minecraft.client.util;

import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

public class JSONException extends IOException
{
    private final List<JSONException.Entry> entries = Lists.newArrayList();
    private final String message;

    public JSONException(String p_i741_1_)
    {
        this.entries.add(new JSONException.Entry());
        this.message = p_i741_1_;
    }

    public JSONException(String p_i742_1_, Throwable p_i742_2_)
    {
        super(p_i742_2_);
        this.entries.add(new JSONException.Entry());
        this.message = p_i742_1_;
    }

    public void prependJsonKey(String key)
    {
        this.entries.get(0).addJsonKey(key);
    }

    public void setFilenameAndFlush(String filenameIn)
    {
        (this.entries.get(0)).filename = filenameIn;
        this.entries.add(0, new JSONException.Entry());
    }

    public String getMessage()
    {
        return "Invalid " + this.entries.get(this.entries.size() - 1) + ": " + this.message;
    }

    public static JSONException forException(Exception exception)
    {
        if (exception instanceof JSONException)
        {
            return (JSONException)exception;
        }
        else
        {
            String s = exception.getMessage();

            if (exception instanceof FileNotFoundException)
            {
                s = "File not found";
            }

            return new JSONException(s, exception);
        }
    }

    public static class Entry
    {
        @Nullable
        private String filename;
        private final List<String> jsonKeys = Lists.newArrayList();

        private Entry()
        {
        }

        private void addJsonKey(String key)
        {
            this.jsonKeys.add(0, key);
        }

        public String getJsonKeys()
        {
            return StringUtils.join((Iterable<?>)this.jsonKeys, "->");
        }

        public String toString()
        {
            if (this.filename != null)
            {
                return this.jsonKeys.isEmpty() ? this.filename : this.filename + " " + this.getJsonKeys();
            }
            else
            {
                return this.jsonKeys.isEmpty() ? "(Unknown file)" : "(Unknown file) " + this.getJsonKeys();
            }
        }
    }
}
