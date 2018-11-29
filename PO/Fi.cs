using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Fi : Constant
    {
        public override double Evaluate()
        {
            return (1 + Math.Sqrt(5)) / 2;
        }

        public override string Result()
        {
            return "fi";
        }
    }
}
