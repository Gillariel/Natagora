<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountNumberSeeBird Model
 *
 * @method \App\Model\Entity\CountNumberSeeBird get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountNumberSeeBird newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountNumberSeeBird[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountNumberSeeBird|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountNumberSeeBird patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountNumberSeeBird[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountNumberSeeBird findOrCreate($search, callable $callback = null, $options = [])
 */
class CountNumberSeeBirdTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('count_number_see_bird');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        $validator
            ->integer('Bird_ID')
            ->requirePresence('Bird_ID', 'create')
            ->notEmpty('Bird_ID');

        return $validator;
    }
}
