/*
 * ManagementUtils.java
 *
 * IBM Confidential
 * GBS Source Materials
 *
 * Copyright (c) 2012 IBM Corp.
 * All Rights Reserved.
 */
package com.iisigroup.cap.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * <pre>
 * ManagementUtils
 * </pre>
 *
 * @since 2012/3/8
 * @author UFO
 * @version
 *          <ul>
 *          <li>2012/3/8,UFO,new
 *          </ul>
 */
public class ManagementUtils {
    private static final long MEGABYTE = 1024L * 1024L;

    public static MemoryUsage getCurrentMemUsage() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        return mem.getHeapMemoryUsage();
    }

    public static String formatHeapMemoryUsage(MemoryUsage beforHeap, MemoryUsage afterHeap) {
        return afterHeap != null ? CapString.concat("Heap Usage: Committed=", bytesToMegabytes(beforHeap.getCommitted()), "->", bytesToMegabytes(afterHeap.getCommitted()), " MB, Init=",
                bytesToMegabytes(beforHeap.getInit()), "->", bytesToMegabytes(afterHeap.getInit()), " MB, Max=", bytesToMegabytes(beforHeap.getMax()), "->", bytesToMegabytes(afterHeap.getMax()),
                " MB, Used=", bytesToMegabytes(beforHeap.getUsed()), "->", bytesToMegabytes(afterHeap.getUsed()), "=", (bytesToMegabytes(afterHeap.getUsed() - beforHeap.getUsed())), " MB ") : "";
    }

    public static String formatHeapMemoryUsage(MemoryUsage heap) {
        return heap != null ? CapString.concat("Heap Usage: Committed=", bytesToMegabytes(heap.getCommitted()), "->", bytesToMegabytes(heap.getCommitted()), " MB, Init=",
                bytesToMegabytes(heap.getInit()), " MB, Max=", bytesToMegabytes(heap.getMax()), " MB, Used=", bytesToMegabytes(heap.getUsed()), " MB ") : "";
    }

    private static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
}
