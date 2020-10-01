module.exports = {
   module: {
      rules: [
         {
            test: /\.css$/i,
            use: ['style-loader', 'css-loader'],
         },
         {
            test: /\.(png|jpg|gif|svg)$/i,
            use: [
               {
                  loader: 'url-loader',
                  options: {
                     limit: false,
                  },
               },
            ],
         },
      ],
   },
};