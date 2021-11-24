package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-25 20:32
 */
public class Face1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        Point[] points = convertPoint(start1, end1, start2, end2);
        Point s1 = points[0];
        Point e1 = points[1];
        Point s2 = points[2];
        Point e2 = points[3];

        Line line1 = new Line(s1, e1);
        Line line2 = new Line(s2, e2);
        // 误差精度
        double epslion = 1e-6f;
        // 两条直线的交点（如果存在的话）
        Point intersection;

        // 情况 1：（特殊情况）两条直线有一条斜率为正无穷
        if (line1.k == Integer.MAX_VALUE || line2.k == Integer.MAX_VALUE) {

            // 两条直线斜率都不存在时
            if (line1.k == Integer.MAX_VALUE && line2.k == Integer.MAX_VALUE) {

                // 这里讨论两条直线重合的情况， b 不是截距的意思，而是表示 x = a 这条线段
                if (Math.abs(line1.b - line2.b) <= epslion && (isBetween(s1, s2, e1)) || isBetween(s2, s1, e2)) {
                    if (isBetween(s1, s2, e1)) {
                        return new double[]{s2.x, s2.y};
                    } else {
                        return new double[]{s1.x, s1.y};
                    }
                }
            }

            // 其中一条直线斜率不存在
            if (line1.k == Integer.MAX_VALUE) {
                intersection = new Point(line1.b, line1.b * line2.k + line2.b);
            } else {
                intersection = new Point(line2.b, line2.b * line1.k + line1.b);
            }

        } else if (Math.abs(line1.k - line2.k) <= epslion) {
            // 情况 2：（特殊情况）斜率相等的情况下，如果在 y 轴上的截距相等，就表示两条直线重合
            if (Math.abs(line1.b - line2.b) <= epslion && isBetween(s1, s2, e1)) {
                return new double[]{s2.x, s2.y};
            }
            return new double[0];
        } else {
            // 情况 3：（一般情况）使用公式计算交点的坐标
            double x = (line2.b - line1.b) / (line1.k - line2.k);
            double y = x * line1.k + line1.b;

            intersection = new Point(x, y);
        }

        // 检测所在直线的交点是否在两条线段的横纵坐标范围之内
        if (isBetween(s1, intersection, e1) && isBetween(s2, intersection, e2)) {
            return new double[]{intersection.x, intersection.y};
        }
        return new double[0];
    }

    private Point[] convertPoint(int[] start1, int[] end1, int[] start2, int[] end2) {
        Point s1 = new Point(start1[0], start1[1]);
        Point e1 = new Point(end1[0], end1[1]);
        Point s2 = new Point(start2[0], start2[1]);
        Point e2 = new Point(end2[0], end2[1]);

        if (s1.x > e1.x) {
            swap(s1, e1);
        }
        if (s2.x > e2.x) {
            swap(s2, e2);
        }
        if (s1.x > s2.x) {
            swap(s1, s2);
            swap(e1, e2);
        }
        return new Point[]{s1, e1, s2, e2};
    }

    private boolean isBetween(double start, double middle, double end) {
        if(start > end){
            return start >= middle && middle >= end;
        }
        return start <= middle && middle <= end;
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }


    /**
     * 交换两个点坐标的数值
     *
     * @param point1
     * @param point2
     */
    private void swap(Point point1, Point point2) {
        double tempX = point1.x;
        double tempY = point1.y;

        point1.x = point2.x;
        point1.y = point2.y;

        point2.x = tempX;
        point2.y = tempY;
    }


    private class Line {
        /**
         * 斜率
         */
        private double k;

        /**
         * 在 y 轴上的截距
         */
        private double b;

        public Line(Point start, Point end) {
            double deltaY = end.y - start.y;
            double deltaX = end.x - start.x;
            // 注意：当 deltaX = 0 的时候，设置斜率为正无穷
            if (deltaX == 0) {
                k = Integer.MAX_VALUE;
                // 此时截距为直线在 x 轴上的截距，这里是特殊的做法
                b = end.x;
            } else {
                k = deltaY / deltaX;
                b = end.y - k * end.x;
            }
        }
    }

    /**
     * 将输入封装成 Point，以便把 int 类型转换成 double 类型，便于计算
     */
    private class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

}
