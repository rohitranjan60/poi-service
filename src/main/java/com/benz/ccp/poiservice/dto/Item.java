package com.benz.ccp.poiservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "position",
    "distance",
    "title",
    "averageRating",
    "category",
    "icon",
    "vicinity",
    "having",
    "type",
    "href",
    "id",
    "openingHours",
    "alternativeNames",
    "tags"
})
public class Item implements Serializable
{

    @JsonProperty("position")
    private List<Double> position = new ArrayList<Double>();
    @JsonProperty("distance")
    private Integer distance;
    @JsonProperty("title")
    private String title;
    @JsonProperty("averageRating")
    private Integer averageRating;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("vicinity")
    private String vicinity;
    @JsonProperty("having")
    private List<Object> having = new ArrayList<Object>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("openingHours")
    private OpeningHours openingHours;
    @JsonProperty("alternativeNames")
    private List<AlternativeName> alternativeNames = new ArrayList<AlternativeName>();
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    private final static long serialVersionUID = 3173174696056468591L;

    @JsonProperty("position")
    public List<Double> getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(List<Double> position) {
        this.position = position;
    }

    @JsonProperty("distance")
    public Integer getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("averageRating")
    public Integer getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("vicinity")
    public String getVicinity() {
        return vicinity;
    }

    @JsonProperty("vicinity")
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @JsonProperty("having")
    public List<Object> getHaving() {
        return having;
    }

    @JsonProperty("having")
    public void setHaving(List<Object> having) {
        this.having = having;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("openingHours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    @JsonProperty("openingHours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    @JsonProperty("alternativeNames")
    public List<AlternativeName> getAlternativeNames() {
        return alternativeNames;
    }

    @JsonProperty("alternativeNames")
    public void setAlternativeNames(List<AlternativeName> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(position).append(distance).append(title).append(averageRating).append(category).append(icon).append(vicinity).append(having).append(type).append(href).append(id).append(openingHours).append(alternativeNames).append(tags).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(position, rhs.position).append(distance, rhs.distance).append(title, rhs.title).append(averageRating, rhs.averageRating).append(category, rhs.category).append(icon, rhs.icon).append(vicinity, rhs.vicinity).append(having, rhs.having).append(type, rhs.type).append(href, rhs.href).append(id, rhs.id).append(openingHours, rhs.openingHours).append(alternativeNames, rhs.alternativeNames).append(tags, rhs.tags).isEquals();
    }

}