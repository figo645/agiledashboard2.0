#!/bin/bash

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 记录日志
log() {
    echo -e "$(date '+%Y-%m-%d %H:%M:%S') - $1"
}

# 检查 Java 环境
check_java() {
    log "${BLUE}检查 Java 环境...${NC}"
    
    if ! command -v java &> /dev/null; then
        log "${RED}错误: Java 未安装${NC}"
        exit 1
    fi
    
    java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
    log "${GREEN}Java 版本: $java_version${NC}"
}

# 检查 Maven 环境
check_maven() {
    log "${BLUE}检查 Maven 环境...${NC}"
    
    if ! command -v mvn &> /dev/null; then
        log "${RED}错误: Maven 未安装${NC}"
        exit 1
    fi
    
    mvn_version=$(mvn -v | awk 'NR==1{print $3}')
    log "${GREEN}Maven 版本: $mvn_version${NC}"
}

# 创建文档目录
create_docs_dir() {
    log "${BLUE}创建文档目录...${NC}"
    
    mkdir -p docs/api
    log "${GREEN}文档目录创建成功${NC}"
}

# 生成 Javadoc
generate_javadoc() {
    log "${BLUE}开始生成 Javadoc...${NC}"
    
    mvn javadoc:javadoc -f docs/javadoc.xml
    
    if [ $? -eq 0 ]; then
        log "${GREEN}Javadoc 生成成功${NC}"
        log "文档位置: docs/api/index.html"
    else
        log "${RED}Javadoc 生成失败${NC}"
        exit 1
    fi
}

# 主程序
main() {
    log "${BLUE}开始生成 API 文档...${NC}"
    
    # 检查环境
    check_java
    check_maven
    
    # 创建目录
    create_docs_dir
    
    # 生成文档
    generate_javadoc
    
    log "${GREEN}API 文档生成完成！${NC}"
}

# 执行主程序
main 