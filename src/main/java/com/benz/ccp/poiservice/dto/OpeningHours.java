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
    "text",
    "label",
    "isOpen",
    "structured"
})
public class OpeningHours implements Serializable
{

    @JsonProperty("text")
    private String text;
    @JsonProperty("label")
    private String label;
    @JsonProperty("isOpen")
    private Boolean isOpen;
    @JsonProperty("structured")
    private List<Structured> structured = new ArrayList<Structured>();
    private final static long serialVersionUID = -1313861148861853491L;

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("isOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    @JsonProperty("isOpen")
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @JsonProperty("structured")
    public List<Structured> getStructured() {
        return structured;
    }

    @JsonProperty("structured")
    public void setStructured(List<Structured> structured) {
        this.structured = structured;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(label).append(isOpen).append(structured).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OpeningHours) == false) {
            return false;
        }
        OpeningHours rhs = ((OpeningHours) other);
        return new EqualsBuilder().append(text, rhs.text).append(label, rhs.label).append(isOpen, rhs.isOpen).append(structured, rhs.structured).isEquals();
    }

}