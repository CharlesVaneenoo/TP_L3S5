make
echo "Remplissage du fichier res.dat \n"

for size in `awk 'BEGIN { for( i=10; i<=10000000; i*=10 ) print i }'`; do 
	./aleazard $size >> "test$size.txt"
done

echo -e "Nombre de génomes Nombre de threads Nombres de GC Taux de GC Durée de calcul" >> res.dat ;

for size2 in `awk 'BEGIN { for( i=10; i<=10000000; i*=10 ) print i }'`; do 
		for size3 in `awk 'BEGIN { for( i=1; i<=32; i*=2 ) print i }'`; do 
			./compteur-gc "test$size2.txt" $size3 >> res.dat
		done
done
#eof

make deltxt

gnuplot run.gnu

make realclean
