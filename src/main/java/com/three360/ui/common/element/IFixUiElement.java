package com.three360.ui.common.element;

/**
 * Created by sainik on 3/23/17.
 */
public interface IFixUiElement<T, K> {

    /***
     *
     * @return
     */
    T create();

    /***
     *
     * @param e
     */
    void registerForEvent(K e);

}
