for size in `awk 'BEGIN { for( i=1; i<=3000000; i++ ) print i }'`; do
    echo $size
done

