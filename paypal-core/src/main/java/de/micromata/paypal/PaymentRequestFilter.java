package de.micromata.paypal;

/**
 * Used for getting payments from the PayPal server.
 */
public class PaymentRequestFilter {
    public enum SORT_BY {CREATE_TIME}

    public enum SORT_ORDER {DESC}

    private Integer count;
    private Integer startIndex;
    private String startId, payeeId;
    private String startTime, endTime;
    private SORT_BY sortBy;
    private SORT_ORDER sortOrder;

    public Integer getCount() {
        return count;
    }

    /**
     * The number of items to list in the response.
     * <p>
     * Default: 10.
     * <p>
     * Maximum value: 20.
     *
     * @param count
     */
    public void setCount(Integer count) {
        if (count < 1){
            throw new IllegalArgumentException("Count can't be zero or negative: " + count);
        }
        if (count > 20) {
            throw new IllegalArgumentException("Count can't be greater than 20: " + count);
        }
        this.count = count;
    }

    public String getStartId() {
        return startId;
    }

    /**
     * The ID of the starting resource in the response. When results are paged, you can use the next_id value as the
     * start_id to continue with the next set of results.
     *
     * @param startId
     */
    public void setStartId(String startId) {
        this.startId = startId;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     * The start index of the payments to list. Typically, you use the start_index to jump to a specific position in
     * the resource history based on its cart. For example, to start at the second item in a list of results, specify ?start_index=2.
     *
     * @param startIndex
     */
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getStartTime() {
        return startTime;
    }

    /**
     * The start date and time for the range to show in the response, in Internet date and time format. For example, start_time=2016-03-06T11:00:00Z.
     *
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    /**
     * The end date and time for the range to show in the response, in Internet date and time format. For example, end_time=2016-03-06T11:00:00Z.
     *
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPayeeId() {
        return payeeId;
    }

    /**
     * Filters the payments in the response by a PayPal-assigned merchant ID that identifies the payee.
     *
     * @param payeeId
     */
    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public SORT_BY getSortBy() {
        return sortBy;
    }

    /**
     * Sorts the payments in the response by a create time.
     * Allowed values: create_time.
     *
     * @param sortBy
     */
    public void setSortBy(SORT_BY sortBy) {
        this.sortBy = sortBy;
    }

    public SORT_ORDER getSortOrder() {
        return sortOrder;
    }

    /**
     * Sorts the payments in the response in descending order.
     * Allowed values: desc.
     *
     * @param sortOrder
     */
    public void setSortOrder(SORT_ORDER sortOrder) {
        this.sortOrder = sortOrder;
    }
}
