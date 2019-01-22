package com.example.morganeankonina.android5779_3884_9325_5513.model.backend;

import com.example.morganeankonina.android5779_3884_9325_5513.entities.Travel;

/**
 * Interface Backend to describe the form of the DB classes
 */
public interface Backend
{
    /**
     *
     * @param travel
     * @throws Exception
     */
    public void addTravel(Travel travel) throws Exception;
}