/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.github.ian4hu.benchmarks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jixu.hjx
 * @version $Id: Model.java, v 0.1 2018年12月29日 09:43 jixu.hjx Exp $
 */
public class Model {

    public static class Tweet implements Serializable {
        @JsonProperty
        private String  coordinates;
        @JsonProperty
        private boolean favorited;
        @JsonProperty
        private Date    created_at;
        @JsonProperty
        private boolean truncated;
        @JsonProperty
        private Tweet   retweeted_status;
        @JsonProperty
        private String  id_str;
        @JsonProperty
        private String  in_reply_to_id_str;
        @JsonProperty
        private String  contributors;
        @JsonProperty
        private String  text;
        @JsonProperty
        private long    id;
        @JsonProperty
        private String  retweet_count;
        @JsonProperty
        private String  in_reply_to_status_id_str;
        @JsonProperty
        private Object  geo;
        @JsonProperty
        private boolean retweeted;
        @JsonProperty
        private String  in_reply_to_user_id;
        @JsonProperty
        private String  in_reply_to_screen_name;
        @JsonProperty
        private Object  place;
        @JsonProperty
        private User    user;
        @JsonProperty
        private String  source;
        @JsonProperty
        private String  in_reply_to_user_id_str;

        public String getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(String coordinates) {
            this.coordinates = coordinates;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public Date getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Date created_at) {
            this.created_at = created_at;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public Tweet getRetweeted_status() {
            return retweeted_status;
        }

        public void setRetweeted_status(Tweet retweeted_status) {
            this.retweeted_status = retweeted_status;
        }

        public String getId_str() {
            return id_str;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public String getIn_reply_to_id_str() {
            return in_reply_to_id_str;
        }

        public void setIn_reply_to_id_str(String in_reply_to_id_str) {
            this.in_reply_to_id_str = in_reply_to_id_str;
        }

        public String getContributors() {
            return contributors;
        }

        public void setContributors(String contributors) {
            this.contributors = contributors;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getRetweet_count() {
            return retweet_count;
        }

        public void setRetweet_count(String retweet_count) {
            this.retweet_count = retweet_count;
        }

        public String getIn_reply_to_status_id_str() {
            return in_reply_to_status_id_str;
        }

        public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
            this.in_reply_to_status_id_str = in_reply_to_status_id_str;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public boolean isRetweeted() {
            return retweeted;
        }

        public void setRetweeted(boolean retweeted) {
            this.retweeted = retweeted;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id(String in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public Object getPlace() {
            return place;
        }

        public void setPlace(Object place) {
            this.place = place;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getIn_reply_to_user_id_str() {
            return in_reply_to_user_id_str;
        }

        public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
            this.in_reply_to_user_id_str = in_reply_to_user_id_str;
        }
    }

    public static class User implements Serializable {
        @JsonProperty
        private
        String  name;
        @JsonProperty
        private
        String  profile_sidebar_border_color;
        @JsonProperty
        private
        boolean profile_background_tile;
        @JsonProperty
        private
        String  profile_sidebar_fill_color;
        @JsonProperty
        private
        Date    created_at;
        @JsonProperty
        private
        String  location;
        @JsonProperty
        private
        String  profile_image_url;
        @JsonProperty
        private
        boolean follow_request_sent;
        @JsonProperty
        private
        String  profile_link_color;
        @JsonProperty
        private
        boolean is_translator;
        @JsonProperty
        private
        String  id_str;
        @JsonProperty
        private
        int     favourites_count;
        @JsonProperty
        private
        boolean contributors_enabled;
        @JsonProperty
        private
        String  url;
        @JsonProperty
        private
        boolean default_profile;
        @JsonProperty
        private
        long    utc_offset;
        @JsonProperty
        private
        long    id;
        @JsonProperty
        private
        boolean profile_use_background_image;
        @JsonProperty
        private
        int     listed_count;
        @JsonProperty
        private
        String  lang;
        @JsonProperty("protected")
        @SerializedName("protected")
        private
        boolean isProtected;
        @JsonProperty
        private
        int     followers_count;
        @JsonProperty
        private
        String  profile_text_color;
        @JsonProperty
        private
        String  profile_background_color;
        @JsonProperty
        private
        String  time_zone;
        @JsonProperty
        private
        String  description;
        @JsonProperty
        private
        boolean notifications;
        @JsonProperty
        private
        boolean geo_enabled;
        @JsonProperty
        private
        boolean verified;
        @JsonProperty
        private
        String  profile_background_image_url;
        @JsonProperty
        private
        boolean defalut_profile_image;
        @JsonProperty
        private
        int     friends_count;
        @JsonProperty
        private
        int     statuses_count;
        @JsonProperty
        private
        String  screen_name;
        @JsonProperty
        private
        boolean following;
        @JsonProperty
        private
        boolean show_all_inline_media;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile_sidebar_border_color() {
            return profile_sidebar_border_color;
        }

        public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
            this.profile_sidebar_border_color = profile_sidebar_border_color;
        }

        public boolean isProfile_background_tile() {
            return profile_background_tile;
        }

        public void setProfile_background_tile(boolean profile_background_tile) {
            this.profile_background_tile = profile_background_tile;
        }

        public String getProfile_sidebar_fill_color() {
            return profile_sidebar_fill_color;
        }

        public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
            this.profile_sidebar_fill_color = profile_sidebar_fill_color;
        }

        public Date getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Date created_at) {
            this.created_at = created_at;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getProfile_image_url() {
            return profile_image_url;
        }

        public void setProfile_image_url(String profile_image_url) {
            this.profile_image_url = profile_image_url;
        }

        public boolean isFollow_request_sent() {
            return follow_request_sent;
        }

        public void setFollow_request_sent(boolean follow_request_sent) {
            this.follow_request_sent = follow_request_sent;
        }

        public String getProfile_link_color() {
            return profile_link_color;
        }

        public void setProfile_link_color(String profile_link_color) {
            this.profile_link_color = profile_link_color;
        }

        public boolean isIs_translator() {
            return is_translator;
        }

        public void setIs_translator(boolean is_translator) {
            this.is_translator = is_translator;
        }

        public String getId_str() {
            return id_str;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public int getFavourites_count() {
            return favourites_count;
        }

        public void setFavourites_count(int favourites_count) {
            this.favourites_count = favourites_count;
        }

        public boolean isContributors_enabled() {
            return contributors_enabled;
        }

        public void setContributors_enabled(boolean contributors_enabled) {
            this.contributors_enabled = contributors_enabled;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isDefault_profile() {
            return default_profile;
        }

        public void setDefault_profile(boolean default_profile) {
            this.default_profile = default_profile;
        }

        public long getUtc_offset() {
            return utc_offset;
        }

        public void setUtc_offset(long utc_offset) {
            this.utc_offset = utc_offset;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public boolean isProfile_use_background_image() {
            return profile_use_background_image;
        }

        public void setProfile_use_background_image(boolean profile_use_background_image) {
            this.profile_use_background_image = profile_use_background_image;
        }

        public int getListed_count() {
            return listed_count;
        }

        public void setListed_count(int listed_count) {
            this.listed_count = listed_count;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public boolean isProtected() {
            return isProtected;
        }

        public void setProtected(boolean aProtected) {
            isProtected = aProtected;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public String getProfile_text_color() {
            return profile_text_color;
        }

        public void setProfile_text_color(String profile_text_color) {
            this.profile_text_color = profile_text_color;
        }

        public String getProfile_background_color() {
            return profile_background_color;
        }

        public void setProfile_background_color(String profile_background_color) {
            this.profile_background_color = profile_background_color;
        }

        public String getTime_zone() {
            return time_zone;
        }

        public void setTime_zone(String time_zone) {
            this.time_zone = time_zone;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isNotifications() {
            return notifications;
        }

        public void setNotifications(boolean notifications) {
            this.notifications = notifications;
        }

        public boolean isGeo_enabled() {
            return geo_enabled;
        }

        public void setGeo_enabled(boolean geo_enabled) {
            this.geo_enabled = geo_enabled;
        }

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public String getProfile_background_image_url() {
            return profile_background_image_url;
        }

        public void setProfile_background_image_url(String profile_background_image_url) {
            this.profile_background_image_url = profile_background_image_url;
        }

        public boolean isDefalut_profile_image() {
            return defalut_profile_image;
        }

        public void setDefalut_profile_image(boolean defalut_profile_image) {
            this.defalut_profile_image = defalut_profile_image;
        }

        public int getFriends_count() {
            return friends_count;
        }

        public void setFriends_count(int friends_count) {
            this.friends_count = friends_count;
        }

        public int getStatuses_count() {
            return statuses_count;
        }

        public void setStatuses_count(int statuses_count) {
            this.statuses_count = statuses_count;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }

        public boolean isShow_all_inline_media() {
            return show_all_inline_media;
        }

        public void setShow_all_inline_media(boolean show_all_inline_media) {
            this.show_all_inline_media = show_all_inline_media;
        }
    }

    public static class Feed implements Serializable {
        @JsonProperty
        private
        String     id;
        @JsonProperty
        private
        String     title;
        @JsonProperty
        private
        String     description;
        @JsonProperty("alternate")
        @SerializedName("alternate")
        private
        List<Link> alternates;
        @JsonProperty
        private
        long       updated;
        @JsonProperty
        private
        List<Item> items;

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder()
                    .append(getId())
                    .append("\n").append(getTitle())
                    .append("\n").append(getDescription())
                    .append("\n").append(getAlternates())
                    .append("\n").append(getUpdated());
            int i = 1;
            for (Item item : getItems()) {
                result.append(i++).append(": ").append(item).append("\n\n");
            }
            return result.toString();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Link> getAlternates() {
            return alternates;
        }

        public void setAlternates(List<Link> alternates) {
            this.alternates = alternates;
        }

        public long getUpdated() {
            return updated;
        }

        public void setUpdated(long updated) {
            this.updated = updated;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    public static class Link implements Serializable {
        @JsonProperty
        private
        String href;

        @Override
        public String toString() {
            return getHref();
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    public static class Item implements Serializable {
        @JsonProperty
        private
        List<String>     categories;
        @JsonProperty
        private
        String           title;
        @JsonProperty
        private
        long             published;
        @JsonProperty
        private
        long             updated;
        @JsonProperty("alternate")
        @SerializedName("alternate")
        private
        List<Link>       alternates;
        @JsonProperty
        private
        Content          content;
        @JsonProperty
        private
        String           author;
        @JsonProperty
        private
        List<ReaderUser> likingUsers;

        @Override
        public String toString() {
            return getTitle()
                    + "\nauthor: " + getAuthor()
                    + "\npublished: " + getPublished()
                    + "\nupdated: " + getUpdated()
                    + "\n" + getContent()
                    + "\nliking users: " + getLikingUsers()
                    + "\nalternates: " + getAlternates()
                    + "\ncategories: " + getCategories();
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getPublished() {
            return published;
        }

        public void setPublished(long published) {
            this.published = published;
        }

        public long getUpdated() {
            return updated;
        }

        public void setUpdated(long updated) {
            this.updated = updated;
        }

        public List<Link> getAlternates() {
            return alternates;
        }

        public void setAlternates(List<Link> alternates) {
            this.alternates = alternates;
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public List<ReaderUser> getLikingUsers() {
            return likingUsers;
        }

        public void setLikingUsers(List<ReaderUser> likingUsers) {
            this.likingUsers = likingUsers;
        }
    }

    public static class Content implements Serializable {
        @JsonProperty
        private String content;

        @Override
        public String toString() {
            return getContent();
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class ReaderUser implements Serializable {
        @JsonProperty
        private
        String userId;

        @Override
        public String toString() {
            return getUserId();
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }


}