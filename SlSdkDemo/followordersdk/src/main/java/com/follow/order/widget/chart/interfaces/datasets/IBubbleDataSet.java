package com.follow.order.widget.chart.interfaces.datasets;

import com.follow.order.widget.chart.data.BubbleEntry;

/**
 * Created by philipp on 21/10/15.
 */
public interface IBubbleDataSet extends IBarLineScatterCandleBubbleDataSet<BubbleEntry> {

    /**
     * Sets the width of the circle that surrounds the bubble when highlighted,
     * in dp.
     *
     * @param width
     */
    void setHighlightCircleWidth(float width);

    float getMaxSize();

    boolean isNormalizeSizeEnabled();

    /**
     * Returns the width of the highlight-circle that surrounds the bubble
      * @return
     */
    float getHighlightCircleWidth();
}
