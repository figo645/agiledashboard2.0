#!/bin/bash

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
BLUE='\033[0;34m'
NC='\033[0m'

# 日志函数
log() {
    echo -e "${YELLOW}[$(date '+%Y-%m-%d %H:%M:%S')] $1${NC}"
}

# 检查 Java 环境
check_java() {
    if ! command -v java &> /dev/null; then
        log "${RED}错误: 未找到 Java 环境${NC}"
        log "${BLUE}请安装 Java 17 或更高版本${NC}"
        log "${BLUE}macOS 用户可以使用 Homebrew 安装: brew install openjdk@17${NC}"
        exit 1
    fi
    log "${GREEN}Java 版本: $(java -version 2>&1 | head -n 1)${NC}"
}

# 检查 Maven 环境
check_maven() {
    if ! command -v mvn &> /dev/null; then
        log "${RED}错误: 未找到 Maven 环境${NC}"
        log "${BLUE}请安装 Maven:${NC}"
        log "${BLUE}macOS 用户可以使用 Homebrew 安装: brew install maven${NC}"
        log "${BLUE}或者从 Maven 官网下载: https://maven.apache.org/download.cgi${NC}"
        log "${BLUE}安装后请确保将 Maven 的 bin 目录添加到 PATH 环境变量中${NC}"
        exit 1
    fi
    log "${GREEN}Maven 版本: $(mvn -v | head -n 1)${NC}"
}

# 创建文档目录
create_docs_dir() {
    if [ ! -d "docs/api" ]; then
        mkdir -p "docs/api"
        log "${GREEN}创建文档目录: docs/api${NC}"
    fi
}

# 生成 Javadoc
generate_javadoc() {
    log "开始生成 Javadoc..."
    mvn javadoc:javadoc -DoutputDirectory=docs/api
    if [ $? -eq 0 ]; then
        log "${GREEN}Javadoc 生成成功！${NC}"
        log "文档位置: $(pwd)/docs/api"
        log "${BLUE}你可以通过浏览器打开 docs/api/index.html 查看生成的文档${NC}"
    else
        log "${RED}Javadoc 生成失败！${NC}"
        log "${BLUE}请检查 Maven 配置和项目结构是否正确${NC}"
        exit 1
    fi
}

# 主函数
main() {
    log "开始检查环境..."
    check_java
    check_maven
    create_docs_dir
    generate_javadoc
}

# 执行主函数
main 