public void qsort()
	{
		quicksort(0, tamanho()-1);
	}
	
	private void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        Celula pivo = primeiro.prox;
	Celula m = primeiro.prox;
        Celula a = primeiro.prox;
	Celula k;
	for(int x =0; x< (esq+dir)/2; x++)
		pivo = pivo.prox;
		for(int x = 0; x<i; x++)
		{
			m = m.prox;
		}
		for(int x =0; x<j; x++)
		{
			a = a.prox;
		}


        while (i <= j) {
            while (m.elemento < pivo.elemento)
	    {
		    i++;
		    m = m.prox;
	    }
            while (a.elemento > pivo.elemento)
	    {
		    j--;
		    for(k = primeiro.prox; k.prox!=a; k = k.prox);
                    a = k;
	    }
            if (i <= j) {
                int tmp = a.elemento;
		a.elemento = m.elemento;
		m.elemento = tmp;
		for(k=primeiro.prox; k.prox!=a; k = k.prox);
		a = k;
		m = m.prox;
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }