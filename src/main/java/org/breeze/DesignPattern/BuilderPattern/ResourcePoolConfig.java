package org.breeze.DesignPattern.BuilderPattern;


import org.springframework.util.StringUtils;

public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    // 一定要私有化构造方法
    private ResourcePoolConfig(Builder  builder){
        name = builder.name;
        maxTotal = builder.maxTotal;
        maxIdle = builder.maxIdle;
        minIdle = builder.minIdle;
    }

    public static class Builder{
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 8;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build(){
            if(StringUtils.isEmpty(name)){
                throw new IllegalArgumentException();
            }
            if(minIdle > maxIdle ){
                throw new IllegalArgumentException();
            }
            //一系列校验逻辑。。。
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name){
            if(StringUtils.isEmpty(name)){
                throw new IllegalArgumentException();
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal){
            if(maxTotal<0){
                throw new IllegalArgumentException();
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle){
            if(maxTotal<0){
                throw new IllegalArgumentException();
            }
            this.maxIdle = maxTotal;
            return this;
        }

        public Builder setMinIdle(int minIdle){
            if(maxTotal<0){
                throw new IllegalArgumentException();
            }
            this.minIdle = minIdle;
            return this;
        }

    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new Builder()
                .setName("config")
                .setMaxIdle(20)
                .setMinIdle(25)
                .build();
    }

}
